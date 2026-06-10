(ns armstrong-numbers)

(defn- exp [x n]
  (reduce * (repeat n x)))

(defn- num-list
  [num list]
  (if (== num 0) list
    (recur (quot num 10)
      (cons (mod num 10) list))))

;; (defn armstrong?
;;   "Returns true if the given number is an Armstrong number;
;;   otherwise, it returns false."
;;   [num]
;;   (let [nl (num-list [] num)
;;         exponent (count nl)]
;;     (== num
;;       (reduce + 
;;       (map #(exp % exponent) nl)))))

;; ;; annotated so that we can see what the ->> macro does
;; (defn armstrong? [num]
;;     (->> num
;;       (num-list [] ,,,)
;;       (map #(exp % (count (str num))) ,,,)
;;       (reduce + ,,,)
;;       (== num ,,,)))

(defn armstrong? [num]
  (->> (num-list num [])
    (map #(exp % (count (str num))))
    (reduce +)
    (== num)))
