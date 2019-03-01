(ns geolocation.views
  (:require
   [re-frame.core :as re-frame]
   [geolocation.subs :as subs]))


(defn get-position []
  (let [geo (.-geolocation js/navigator)]
    (.getCurrentPosition geo (fn [pos]
                               (re-frame/dispatch [:location {:latitude (.-latitude (.-coords pos))
                                                              :longitude (.-longitude (.-coords pos))}])))))


(defn main-panel []
  (let [location @(re-frame/subscribe [:location])]
    [:div
     [:h1 "Geolocation example"]
     [:button {:on-click #(get-position)} "get location"]
     [:div "Latitude: " (:latitude location) " Longitude: " (:longitude location)]]))
