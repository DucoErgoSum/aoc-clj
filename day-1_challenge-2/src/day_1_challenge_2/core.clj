(ns day-1-challenge-2.core
  (:gen-class))
(require '[clojure.string :as str])

(def elves (map #(str/split % #"\r?\n") (str/split (slurp "resources/input.txt") #"\r?\n\r?\n")))
(def totals (mapv (fn [coll] (reduce + (map parse-long coll))) elves))
(def three-highest-calories (take-last 3 (sort totals)))
(def sum-three-highest (apply + three-highest-calories))

(defn -main
  "I print the sum of the top three calories"
  [& args]
  (println sum-three-highest))
