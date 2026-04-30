(ns collatz-conjecture)

(defn collatz
  "Returns the number of steps for num to reach 1
  according to the Collatz Conjecture."
  ([num] 
    (collatz num 0))
  ([n iter]
    (if (= n 1) iter 
      (if (= (mod n 2) 0) (collatz (/ n 2) (inc iter))
        (collatz (+ (* n 3) 1) (inc iter))))))
