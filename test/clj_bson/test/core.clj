(ns clj-bson.test.core
  (:use [clj-bson.core] :reload)
  (:use [clojure.test]))

(deftest encode-test
  (let [value {:my "object"}
        encoded (encode value)
        decoded (decode encoded)]
    (is encoded)
    (is (not (= value encoded)))
    (is (not (= decoded encoded)))
    (is (= value decoded))))
