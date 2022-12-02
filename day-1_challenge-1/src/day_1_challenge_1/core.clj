(ns day-1-challenge-1.core
  (:gen-class))
(require '[clojure.string :as str])

(def elves (map #(str/split % #"\r?\n") (str/split (slurp "resources/input.txt") #"\r?\n\r?\n")))
(def totals (mapv (fn [coll] (reduce + (map #(Integer. %) coll))) elves))
(def highest-calories (apply max totals))

(defn -main
  "I print the highest calories"
  [& args]
  (println highest-calories))