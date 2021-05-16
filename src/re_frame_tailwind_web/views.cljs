(ns re-frame-tailwind-web.views
  (:require
   [re-frame.core :as re-frame]
   [re-frame-tailwind-web.subs :as subs]
   [re-frame-tailwind-web.events :as events]
   [goog.string :as gstring]))



(defn nav-link
  [link name]
  [:a {:href link} name])

(defn sidebar
  []
  [:div.h-full.w-0.fixed.z-10.top-0.left-auto.bg-white.overflow-x-hidden.pt-16.transition.flex.flex.justify-between
   {:class "font-Ubuntu font-light text-left tracking-normal"}
   (map #(apply nav-link %)
        [["https://www.rojukiss.com/" [:img {:src "img/ROJUKISS.png" :alt "ROJUKISS"}]]
         ["#" "About Us"]
         ["#" "Brands"]
         ["#" "Sustainability"]
         ["#" "Corporate Governance"]
         ["#" "Investor Relations"]
         ["#" "News & Media"]
         ["#" "Careers"]
         ["#" "Contact Us"]])])

(defn navbar []
  [:nav.flex.justify-between.top-0.left-0.flex-shrink-0 {:style {:width "75px"}}
   [:div.flex.flex-col.items-center]
   [:ul
    [:li>a {:href "#"} "+"]
    [:li>a.uppercase {:href "#"} (gstring/unescapeEntities "&#9776;") "menu"]
    [:li>a.uppercase {:href "#"} "brand"]
    [:li>a.uppercase {:href "#"} "th"]
    [:li>a {:href "#"} "Tel"]]])

(defn main-panel []
  (let [destinations (re-frame/subscribe [::subs/destinations])]
    [:div
     [:header {:style {:height "768px"}}
      [:div.top-0.left-0.h-16.bg-white>img.top-3.m-auto.h-10 {:src "img/ROJUKISS-1.png" :alt "ROJUKISS"}]
      [:div.flex
       (navbar)
       [:div.grid.lg:grid-cols-2.2xl:grid-cols-2
        [:img {:src "img/beach-work.jpg"}]
        [:div "Leading in Asian Beauty"]]]]
     [:div "2"]
     [:footer "3"]]))
