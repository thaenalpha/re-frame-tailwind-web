(ns re-frame-tailwind-web.events
  (:require
   [re-frame.core :as re-frame]
   [re-frame-tailwind-web.db :as db]
   ))

(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))
