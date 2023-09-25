(ns brave-clojure.brave-clojure
  (:gen-class) 
  (:require [clojure.string :as string]))

(def filename "resources/suspects.csv")
(slurp filename)

(defn parse [string]
  (map #(string/split % #",") (string/split string #"\n")))

(parse (slurp filename))