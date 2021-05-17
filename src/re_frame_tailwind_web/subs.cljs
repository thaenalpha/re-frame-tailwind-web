(ns re-frame-tailwind-web.subs
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::main-display
 (fn [db]
   (:main-display db)))

(re-frame/reg-sub
 ::menu-display
 (fn [db]
   (:menu-display db)))

(re-frame/reg-sub
 ::destinations
 (fn [db]
   (:destinations db)))
