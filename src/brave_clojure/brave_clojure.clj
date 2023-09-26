(ns brave-clojure.brave-clojure
  (:gen-class) 
  (:require [clojure.string :as string]))

(def filename "resources/suspects.csv")

(defn parse [filename-string]
  (map #(string/split % #",") (string/split filename-string #"\n")))

(parse (slurp filename))