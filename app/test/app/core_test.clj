(ns app.core-test
  (:require [clojure.test :refer :all]
            [app.core :refer :all]))

(deftest test-add-to-stack
	(is (= '(1) (add-to-stack 1 ())))
)

(deftest test-remove-from-stack
	(is (= () (remove-from-stack '(1))))
)

(deftest test-apply-move
	(is
		(= {:a (), :b '(1), :c ()}
	   		(apply-move [:a :b] {:a '(1), :b (), :c ()})))
)

(deftest test-apply-stack-1
	(is 
		(= {:a '(), :b (), :c '(1)}
		(solve 1 {:a '(1), :b (), :c ()})
		)
	)
)

(deftest test-stack-2-solve-1
	(is 
		(= {:a '(2), :b (), :c '(1)}
		(solve 1 {:a '(1,2), :b (), :c ()})
		)
	)
)

(deftest test-stack-2-solve-2
	(is 
		(= {:a '(), :b (), :c '(1,2)}
		(solve 2 {:a '(1,2), :b (), :c ()})
		)
	)
)

;(deftest test-stack-3-solve-3
;	(is 
;		(= {:a '(), :b (), :c '(1,2,3)}
;		(solve 3 {:a '(1,2,3), :b (), :c ()})
;		)
;	)
;)
