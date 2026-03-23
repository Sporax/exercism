(ns difference-of-squares)

(defn square-of-sum
  "Returns the square of the sum of the numbers up to N."
  [n]
  ;; sum(1 + 2 + .. + n-1 + n) = (n * (n+1)) / 2
  (let [sum (/ (* n (+ n 1)) 2)]
    (* sum sum)))

(defn sum-of-squares
  "Returns the sum of the squares of the numbers up to N."
  [n]
  ;; sum(1^2 + 2^2 + ... + (n-1)^2 + n^2) = (n * (n+1) * (2n+1)) / 6
  (/ (* n (+ n 1) (+ (* 2 n) 1)) 6))

(defn difference
  "Returns the difference between the square of the sum
  and the sum of the squares of the numbers up to N."
  [n]
  (- (square-of-sum n) (sum-of-squares n)))
