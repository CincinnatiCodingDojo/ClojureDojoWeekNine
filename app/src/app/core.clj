(ns app.core)

(defn add-to-stack [disc currentPole]
	(conj currentPole disc)
)

(defn remove-from-stack [currentPole]
	(pop currentPole)
)

(defn apply-move [[src dst] towers]
	(let [srcPole (towers src)
		  dstPole (towers dst)
		  disc (peek srcPole)
		  newSrc (remove-from-stack srcPole)
		  newDst (add-to-stack disc dstPole)]
	    (-> towers
	    	(assoc src newSrc)
	    	(assoc dst newDst))))

(defn stage [disc towers]
		(apply-move [:a :b] towers)
)

(defn unstage [disc towers]
		(apply-move [:b :c] towers)
)

(defn solve [disc towers]
	(cond (= disc 1) (apply-move [:a :c] towers)
	      (= disc 2) (->> towers 
						(stage 1) 
						(solve 1) 
						(unstage 1))
	      :else (->> towers
	      	         (solve (dec disc))
	      	         (solve 1)))
)

(defn solve2 [towers src dst]
	(let [srcPole (towers src)
		  disc (peek srcPole)])
)
