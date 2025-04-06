/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/28/2025
 * File Name: RuntimeTypeAdapterFactory.java
 * Description: Type adapter factory to support polymorphic serialization and deserialization
 *              of abstract base types (e.g., Race, Job, GameCharacter) with Gson.
 *              Adjusted from the Gson repository since it was no longer supported in newer
 *              update.
 */

package edu.bu.met.cs665.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter; 
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
 
/**
 * RuntimeTypeAdapterFactory from Gson's user guide.
 * Allows serialization/deserialization of abstract types by adding a type field (e.g., "type").
 * This class supports dynamically registering subclasses using {@code registerSubtype()}.
 */
public final class RuntimeTypeAdapterFactory<T> implements TypeAdapterFactory {
  private final Class<?> baseType;
  private final String typeFieldName;
  private final boolean maintainType;
  private final Map<String, Class<?>> labelToSubtype = new LinkedHashMap<>();
  private final Map<Class<?>, String> subtypeToLabel = new LinkedHashMap<>();
 
  private RuntimeTypeAdapterFactory(Class<?> baseType, String typeFieldName, boolean maintainType) {
    if (typeFieldName == null || baseType == null) {
      throw new NullPointerException();
    }
    this.baseType = baseType;
    this.typeFieldName = typeFieldName;
    this.maintainType = maintainType;
  }
 
  public static <T> RuntimeTypeAdapterFactory<T> of(Class<T> baseType, String typeFieldName) {
    return new RuntimeTypeAdapterFactory<>(baseType, typeFieldName, false);
  }
 
  public static <T> RuntimeTypeAdapterFactory<T> of(Class<T> baseType) {
    return new RuntimeTypeAdapterFactory<>(baseType, "type", false);
  }
 
  /**
   * Registers a subtype using its simple class name as the label.
   * @param type The subclass of the base type to register.
   * @return This RuntimeTypeAdapterFactory instance.
   */
  public RuntimeTypeAdapterFactory<T> registerSubtype(Class<? extends T> type, String label) {
    if (type == null || label == null) {
      throw new NullPointerException();
    }
    if (subtypeToLabel.containsKey(type) || labelToSubtype.containsKey(label)) {
      throw new IllegalArgumentException("types and labels must be unique");
    }
    labelToSubtype.put(label, type);
    subtypeToLabel.put(type, label);
    return this;
  }
 
  public RuntimeTypeAdapterFactory<T> registerSubtype(Class<? extends T> type) {
    return registerSubtype(type, type.getSimpleName());
  }
 
  /**
   * Creates a {@code TypeAdapter} that can serialize and deserialize the given base type
   * with a "type" discriminator field.
   *
   * @param gson Gson instance.
   * @param type The target type token.
   * @param <R> Runtime type.
   * @return The custom {@code TypeAdapter} that handles polymorphic types.
   */
  @Override
  @SuppressWarnings("unchecked")
  public <R> TypeAdapter<R> create(Gson gson, TypeToken<R> type) {
    if (!baseType.isAssignableFrom(type.getRawType())) {
      return null;
    }
 
    final Map<String, TypeAdapter<?>> labelToDelegate = new LinkedHashMap<>();
    final Map<Class<?>, TypeAdapter<?>> subtypeToDelegate = new LinkedHashMap<>();
    for (Map.Entry<String, Class<?>> entry : labelToSubtype.entrySet()) {
      TypeAdapter<?> delegate = gson.getDelegateAdapter(this, TypeToken.get(entry.getValue()));
      labelToDelegate.put(entry.getKey(), delegate);
      subtypeToDelegate.put(entry.getValue(), delegate);
    }
 
    // Polymorphic TypeAdapter with embedded "type" field handling.
    return new TypeAdapter<R>() {
 
      /**
       * Deserialize an object from JSON with a type field.
       */
      @Override
      public R read(JsonReader in) throws IOException {
        JsonElement jsonElement = Streams.parse(in);
        JsonElement labelJsonElement =
            jsonElement.getAsJsonObject().remove(typeFieldName);
 
        if (labelJsonElement == null) {
          throw new JsonParseException(
              "Cannot deserialize " + baseType + " because it does not define field: "
              + typeFieldName);
        }
 
        String label = labelJsonElement.getAsString();
        TypeAdapter<R> delegate = (TypeAdapter<R>) labelToDelegate.get(label);
        if (delegate == null) {
          throw new JsonParseException(
              "Cannot deserialize " + baseType + " subtype: " + label
              + "; did you forget to register a subtype?");
        }
 
        return delegate.fromJsonTree(jsonElement);
      }
 
      /**
       * Serialize an object to JSON, embedding a type field if needed.
       */
      @Override
      public void write(JsonWriter out, R value) throws IOException {
        Class<?> srcType = value.getClass();
        String label = subtypeToLabel.get(srcType);
        TypeAdapter<R> delegate = (TypeAdapter<R>) subtypeToDelegate.get(srcType);
 
        if (delegate == null) {
          throw new JsonParseException(
              "Cannot serialize " + srcType.getName()
              + "; did you forget to register a subtype?");
        }
 
        JsonObject jsonObject = delegate.toJsonTree(value).getAsJsonObject();
        if (maintainType) {
          Streams.write(jsonObject, out);
          return;
        }
 
        JsonObject clone = new JsonObject();
        if (!jsonObject.has(typeFieldName)) {
          clone.add(typeFieldName, new JsonPrimitive(label));
        }
 
        for (Map.Entry<String, JsonElement> e : jsonObject.entrySet()) {
          clone.add(e.getKey(), e.getValue());
        }
 
        Streams.write(clone, out);
      }
    }.nullSafe();
  }
}
 