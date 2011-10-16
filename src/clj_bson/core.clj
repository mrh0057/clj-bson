(ns clj-bson.core
  (:use somnium.congomongo.coerce)
  (:import [org.bson BSONEncoder
            BasicBSONDecoder]))

(defn encode
  "Returns the encoded bytes.

map 
  The map to encode.
returns
  The bytes"
  [map]
  (let [encoder (BSONEncoder.)]
    (.encode encoder (coerce map [:clojure :mongo]))))

(defn decode
  "Decodes the bytes into a clojure object.

b - The bytes to decode.

return
  The clojure map."
  [^bytes b]
  (let [decoder (BasicBSONDecoder. )]
    (coerce (.readObject decoder b) [:mongo :clojure])))
