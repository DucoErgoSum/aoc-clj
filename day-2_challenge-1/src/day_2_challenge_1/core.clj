(ns day-2-challenge-1.core
  (:gen-class))
(require '[clojure.string :as str])

(def plays (map #(str/split % #" ") (str/split (slurp "resources/input.txt") #"\r?\n"))) ;;  Convert file into list of vectors of keywords as strings
(def player-1 {:A 1 :B 2 :C 3})                             ;;  Map of Player 1 scores
(def player-2 {:X 1 :Y 2 :Z 3})                             ;;  Map of Player 2 scores
(def lookup (mapv (fn [coll] (vec (map #(keyword %) coll))) plays)) ;;  Convert strings into keywords
(def p1-moves (reduce + (map player-1 (map last lookup))))  ;;  Score for all the player-2 moves made in the guide
(def p2-moves (reduce + (map player-2 (map last lookup))))  ;;  Score for all the player-2 moves made in the guide
(defn p1-scores [input] (case input ([:A :X] [:B :Y] [:C :Z]) 3 ([:A :Y] [:B :Z] [:C :X]) 0 ([:A :Z] [:B :X] [:C :Y]) 6)) ;; Get score for Player-1
(defn p2-scores [input] (case input ([:A :X] [:B :Y] [:C :Z]) 3 ([:A :Y] [:B :Z] [:C :X]) 6 ([:A :Z] [:B :X] [:C :Y]) 0)) ;; Get score for Player-2
(def p1-outcomes (reduce + (map p1-scores lookup)))         ;;  Add up all the P1 scores
(def p2-outcomes (reduce + (map p2-scores lookup)))         ;;  Add up all the P2 scores
(def p1-totals (+ p1-moves p1-outcomes))                    ;;  Combine the p1-moves and p1-scores
(def p2-totals (+ p2-moves p2-outcomes))                    ;;  Combine the p2-moves and p2-scores


(defn -main
  "Calculate the scoreboard for player 2"
  [& args]
  (map #(println %) p2-totals))
