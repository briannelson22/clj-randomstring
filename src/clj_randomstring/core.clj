(ns clj-randomstring.core
	(:require [clj-time.core :as t]
		[clj-time.format :as f]))

(defn hello-shared 
  "I don't do a whole lot."
  [x]
  (str x " Hello, World!"))

(defn hello 
  "I don't do a whole lot."
  [x]
  (println (hello-shared x)))

(defn handler-hello
	"My Sample http request handler"
	[request]
	{
	:status 200
	:headers {"Content-Type" "text/html"}
	:body (hello-shared "Kelly")})

(defn handler-remote-ip
	"Handler that returns the requests ip address"
	[request]
	{
	:status 200
	:headers {"Content-Type" "text/plain"}
	:body (:remote-addr request)})	

(defn num-to-month
	[num]
	(subs (f/unparse (f/formatter "MMM") (t/date-time 1970 num 01)) 0 1))

(defn part1
	[in-date]
	(num-to-month (mod (+ (t/month in-date) (t/hour in-date)) 12)))

(defn part2
	[in-date]
	(+ (t/day in-date) (t/minute in-date) -9))

(defn part3
	[in-date]
	(let [result (+ (t/year in-date) (t/second in-date) -2011)]
		(str
			(cond
				(< result 0) "N"
				(> result 0) "P"
				:else "Z")
			result
		)))
	
	
(defn random-string
	"Generate a random string"
	[in-date]
	(str 
		(part1 in-date)
		(part2 in-date)
		(part3 in-date)))
