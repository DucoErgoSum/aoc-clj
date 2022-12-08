(ns day-5-challenge-2.core
  (:gen-class))
(require '[clojure.string :as str])

(def data  (str/split (slurp "resources/input.txt") #"\r?\n")) ;;  Convert file into list of strings.
(def natural-commands (nthrest data 10))
(def instructions (mapv(fn [coll] (vec (map #(Integer. %) (re-seq #"\d+" coll)))) natural-commands))
(def columns-rows (take 8 data))
(def rows (partial nth (apply mapv vector columns-rows)))
(def chart (map #(rows %) [1 5 9 13 17 21 25 29 33]))
(def start-strings (map #(apply str (reverse (str/trim (apply str %)))) chart))
(def strings (atom {
                    :1 (nth start-strings 0)
                    :2 (nth start-strings 1)
                    :3 (nth start-strings 2)
                    :4 (nth start-strings 3)
                    :5 (nth start-strings 4)
                    :6 (nth start-strings 5)
                    :7 (nth start-strings 6)
                    :8 (nth start-strings 7)
                    :9 (nth start-strings 8)
                    }))
(doseq [inst instructions] (let [x (split-at (first inst) (reverse ((keyword (str (second inst))) @strings)))]
                                                (swap! strings assoc
                                                       (keyword (str (second inst)))
                                                       (str (str/join (reverse (last x))))
                                                       )
                                                (swap! strings update-in
                                                       [(keyword (str (last inst)))]
                                                       str (str/join (reverse (first x)))
                                                       )
                                                ))

(def final-9 (str/join (map #(str/join %) [
                                           (take-last 1 (:1 @strings))
                                           (take-last 1 (:2 @strings))
                                           (take-last 1 (:3 @strings))
                                           (take-last 1 (:4 @strings))
                                           (take-last 1 (:5 @strings))
                                           (take-last 1 (:6 @strings))
                                           (take-last 1 (:7 @strings))
                                           (take-last 1 (:8 @strings))
                                           (take-last 1 (:9 @strings))
                                           ])))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println final-9))