(ns geolocation.events
  (:require
   [re-frame.core :as re-frame]
   [geolocation.db :as db]))

(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))

(re-frame/reg-event-db
 :location
 (fn [db [_ location-map]]
   (assoc db :location location-map)))
