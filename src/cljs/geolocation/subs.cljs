(ns geolocation.subs
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :db
 (fn [db]
   db))

(re-frame/reg-sub
 :location
 (fn [db]
   (:location db)))
