(ns re-frame-tailwind-web.events
  (:require
   [re-frame.core :as re-frame]
   [re-frame-tailwind-web.db :as db]))

(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))

(re-frame/reg-event-db
 ::display-menu
 (fn [db [_ sidenav]]
   (-> db
       (assoc :menu-display
              [:div]))))

(re-frame/reg-event-db
 ::close-menu
 (fn [db]
   (assoc db :sidenav-width "298px")))
