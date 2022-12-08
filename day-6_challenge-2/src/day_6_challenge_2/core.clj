(ns day-6-challenge-2.core
  (:gen-class))
(require '[clojure.string :as str])

(def stream  (slurp "resources/input.txt")) ;;  Convert file into list of strings.
(def slide (mapv (fn [coll] (-> coll distinct count)) (map #(str/join %) (partition 14 1 stream))))
(def message (+ (first (map first (filter #(= (second %) 14) (map-indexed vector slide)))) 14))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println message))
