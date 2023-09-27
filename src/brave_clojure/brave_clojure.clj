(ns brave-clojure.brave-clojure
  (:gen-class) 
  (:require [clojure.string :as string]))

(def filename "resources/suspects.csv")

(defn parse [filename-string]
  (map #(string/split % #",") (string/split filename-string #"\n")))

(parse (slurp filename))

(def map-keys [:name :age])

(defn str->int
  [str]
  (Integer. str))

;assoc a function to apply for a key
(def conversions {:name identity
                  :age str->int})

; apply the function for a key
(defn convert
  [age-key value]
  ((get conversions age-key) value))


(defn mapify
  "Return a seq of maps like {:name \"Edward Cullen\" :age 10}"
  [rows]
  (map (fn [unmapped-row]
         (reduce (fn [row-map [key value]]
                   (assoc row-map key (convert key value)))
                 {}
                 (map vector map-keys unmapped-row)))
       rows))

(mapify (parse (slurp filename)))