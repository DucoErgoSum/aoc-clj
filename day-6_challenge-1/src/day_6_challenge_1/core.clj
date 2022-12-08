(ns day-6-challenge-1.core
  (:gen-class))
(require '[clojure.string :as str])

(def stream  (slurp "resources/input.txt")) ;;  Convert file into list of strings.
(def slide (mapv (fn [coll] (-> coll distinct count)) (map #(str/join %) (partition 4 1 stream))))
(def lock (+ (first (map first (filter #(= (second %) 4) (map-indexed vector slide)))) 4))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println lock))
