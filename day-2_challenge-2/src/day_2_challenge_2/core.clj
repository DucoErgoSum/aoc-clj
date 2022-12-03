(ns day-2-challenge-2.core
  (:gen-class))
(require '[clojure.string :as str])

(def plays (map #(str/split % #" ") (str/split (slurp "resources/input.txt") #"\r?\n"))) ;;  Convert file into list of vectors of keywords as strings
(def lookup (mapv (fn [coll] (vec (map #(keyword %) coll))) plays)) ;;  Convert strings into keywords
(defn p2-scores [input] (case input ([:A :Y] [:B :Y] [:C :Y]) 3 ([:A :Z] [:B :Z] [:C :Z]) 6 ([:A :X] [:B :X] [:C :X]) 0)) ;; Get score for Player-2
(def p2-outcomes (reduce + (map p2-scores lookup)))         ;;  Add up all the P2 scores
(defn win [input] (case (first input) (:A) 2 (:B) 3 (:C) 1))
(defn lose [input] (case (first input) (:A) 3 (:B) 1 (:C) 2))
(defn draw [input] (case (first input) (:A) 1 (:B) 2 (:C) 3))
(def p2-moves (reduce + (map #(case (last %) (:X) (lose %) (:Y) (draw %) (:Z) (win %)) lookup)))  ;;  Score for all the player-2 moves made in the guide
(def p2-totals (+ p2-moves p2-outcomes))                    ;;  Combine the p2-moves and p2-scores

(defn -main
  "Calculate the scoreboard for player 2"
  [& args]
  (println p2-totals) )
