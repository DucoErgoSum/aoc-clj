(ns day-4-challenge-2.core
  (:gen-class))
(require '[clojure.string :as str])

(def tester [['(1 10) '(20 30)] ['(20 30) '(1 10)] ['(1 10) '(5 15)] ['(5 15) '(1 10)] ['(40 40) '(40 40)] ['(60 100) '(70 90)] ['(70 90) '(60 100)]])

(def sections  (map #(str/split % #",") (str/split (slurp "resources/input.txt") #"\r?\n"))) ;;  Convert file into list of strings.
(def my-pairs (mapv (fn [limits] (mapv (fn [coll] (map #(Integer. %) coll)) (map #(str/split % #"-") limits))) sections))
(defn ff [pair] (-> pair first first))
(defn fl [pair] (-> pair first last))
(defn lf [pair] (-> pair last first))
(defn ll [pair] (-> pair last last))
(def collision-counter (reduce + (map #(if (or (and (>= (fl %) (lf %)) (<= (fl %) (ll %))) (and (>= (ff %) (lf %)) (<= (ff %) (ll %))) (and (>= (lf %) (ff %)) (<= (lf %) (fl %))) (and (>= (ll %) (ff %)) (<= (ll %) (fl %)))) 1 0) my-pairs)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println collision-counter))
