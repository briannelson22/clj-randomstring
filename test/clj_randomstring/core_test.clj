(ns clj-randomstring.core-test
  (:require [clojure.test :refer :all]
            [clj-randomstring.core :refer :all]))

(deftest part1
  (testing "part1"
    (is (= "J" (part1 (t/date-time 2015 01 01 05 25 35))))))

(deftest part2
  (testing "part2"
    (is (= "17" (part2 (t/date-time 2015 01 01 05 25 35))))))

(deftest part3
  (testing "part3"
    (is (= "P39" (part3 (t/date-time 2015 01 01 05 25 35))))))
 
(deftest random-date
  (testing "random-date"
    (is (= "J17P39" (random-string "20150101" "052535"))))
