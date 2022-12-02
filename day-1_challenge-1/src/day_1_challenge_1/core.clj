(ns day-1-challenge-1.core
  (:gen-class))
(require '[clojure.string :as str])

(def elves (map #(str/split % #"\r?\n") (str/split (slurp "resources/calories.txt") #"\r?\n\r?\n")))
(def totals (let [[Hughy Chesterfield Craston Marmite Tim] elves]
              [(reduce + (map #(Integer. %) Hughy))
                    (reduce + (map #(Integer. %) Chesterfield))
                    (reduce + (map #(Integer. %) Craston))
                    (reduce + (map #(Integer. %) Marmite))
                    (reduce + (map #(Integer. %) Tim))]))
(def highest-calories (apply max totals))

(defn -main
  "I print the highest calories"
  [& args]
  (println highest-calories))