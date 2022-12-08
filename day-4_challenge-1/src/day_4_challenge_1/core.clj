(ns day-4-challenge-1.core
  (:gen-class))
(require '[clojure.string :as str])

(def sections  (map #(str/split % #",") (str/split (slurp "resources/input.txt") #"\r?\n"))) ;;  Convert file into list of strings.
(def my-pairs (mapv (fn [limits] (mapv (fn [coll] (map #(Integer. %) coll)) (map #(str/split % #"-") limits))) sections))
(defn ff [pair] (-> pair first first))
(defn fl [pair] (-> pair first last))
(defn lf [pair] (-> pair last first))
(defn ll [pair] (-> pair last last))
(def subset-counter  (reduce + (map #(if (or (and (>= (ff %) (lf %)) (<= (fl %) (ll %))) (and (>= (lf %) (ff %)) (<= (ll %) (fl %)))) 1 0) my-pairs)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println subset-counter))