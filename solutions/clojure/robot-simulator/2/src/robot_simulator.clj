(ns robot-simulator)

(def rotL {:north :west :west :south :south :east :east :north})
(def rotR {:north :east :west :north :south :west :east :south})

(defn robot
  "Creates a robot at the given coordinates, facing the given direction."
  [coordinates direction]
  {:bearing direction :coordinates coordinates})

(defn advance [state]
  (case (state :bearing)
    :north (assoc-in state [:coordinates :y] (+ (get-in state [:coordinates :y]) 1))
    :west (assoc-in state [:coordinates :x] (- (get-in state [:coordinates :x]) 1))
    :south (assoc-in state [:coordinates :y] (- (get-in state [:coordinates :y]) 1))
    :east (assoc-in state [:coordinates :x] (+ (get-in state [:coordinates :x]) 1))))

(defn action [oper state]
  (case oper
   \L (assoc state :bearing (rotL (state :bearing)))
   \R (assoc state :bearing (rotR (state :bearing)))
   \A (advance state)))

(defn simulate
  "Simulates the robot's movements based on the given instructions
  and updates its state."
  [instructions robot-state]
  (if (empty? instructions) robot-state
    (recur (rest instructions)
     (action (first instructions) robot-state))))
