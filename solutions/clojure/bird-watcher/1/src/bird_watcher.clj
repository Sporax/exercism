(ns bird-watcher)

(def last-week [0 2 5 3 7 8 4])

(defn today [birds] (last birds))

(defn inc-bird [birds]
  (assoc birds (dec (count birds)) (inc (today birds)))) 

(defn day-without-birds? [birds]
  (boolean (some zero? birds)))

(defn n-days-count [birds n]
  (reduce + (take n birds)))

(defn busy-days [birds]
  (count (filter #(> % 4) birds)))

(defn odd-week? [birds]
  (every? true? 
    (for [i (range (count birds))]
      (if (or (and (even? i) (not= (get birds i) 1))
            (and (odd? i) (not= (get birds i) 0)))
          false
          true))))