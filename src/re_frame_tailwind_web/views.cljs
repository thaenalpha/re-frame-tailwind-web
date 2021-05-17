(ns re-frame-tailwind-web.views
  (:require
   [re-frame.core :as re-frame]
   [re-frame-tailwind-web.subs :as subs]
   [re-frame-tailwind-web.events :as events]
   [goog.string :as gstring]))

(defn nav-link
  [link name]
  [:a {:key name :href link} name])

(def sidenav
  [:div#side-nav.h-full.w-0.fixed.z-10.top-0.left-auto.bg-white.overflow-x-hidden.pt-16.transition.flex.flex.justify-between
   {:class "font-Ubuntu font-light text-left tracking-normal"
    :style {:width "298px"}}
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

(def navbar
  [:nav.fixed.z-10.top-0.left-0.overflow-x-hidden.bg-white.bg-no-repeat.bg-clip-padding.w-16
   [:ul.grid.grid-flow-row.h-screen
    [:li.row-start-2>a {:href "#"} [:img.mx-auto {:src "img/ROJUKISS+.png" :width "31px" :height "38px"}]]
    [:li.row-start-4.text-center>a.uppercase {:href "#" :on-click #(re-frame/dispatch [::events/display-menu sidenav])}
     (gstring/unescapeEntities "&#9776;") [:br] "menu"]
    [:li.row-end-7.flex.flex-col.items-center.justify-around
     [:a.uppercase {:href "#"} "brand"]
     [:a.uppercase {:href "#"} "th"]
     [:a {:href "#"} "Tel"]]]])

(defn main-display [destinations]
  [:div
   [:div.grid.lg:grid-cols-5.2xl:grid-cols-5.h-screen.lg:grid-rows-3
    [:img.lg:col-span-3.lg:row-span-3.inset-0.lg:w-full.h-full.objet.cover.objet.center {:src "img/beach-work.jpg" :alt "Woman..."}]
    [:div.lg:col-span-2.lg:row-span-2.flex [:h1.m-auto.font-light.text-7xl {:style {:font-family "'Ubuntu', sans-serif"}} "Leading" [:br] "in Asian Beauty"]]
    (map #(vector :img.inset-0.lg:w-full.h-full.objet.cover.objet.center {:key (:city %) :src (:imageUrl %) :alt (:imageAlt %)}) destinations)]
   [:div.grid.lg:grid-cols-5>i.fas.fa-chevron-circle-left.lg:col-start-4.z-10.-mt-36.text-5xl.-ml-6]])

(defn main-panel []
  (let [destinations (re-frame/subscribe [::subs/destinations])
        menu-display (re-frame/subscribe [::subs/menu-display])]
    [:div.ml-16
     navbar @menu-display
     [:header
      [:div.fixed.z-20.top-0.left-0.overflow-y-hidden.bg-white.bg-no-repeat.bg-clip-padding.shadow.w-full>img.top-3.mx-auto.h-16
       {:src "img/ROJUKISS-1.png" :alt "ROJUKISS"}]
      (main-display (take 2 @destinations))]
     [:div (map #(vector :img.inset-0.lg:w-full.h-full.objet.cover.objet.center {:key (:city %) :src (:imageUrl %) :alt (:imageAlt %)}) (rest (rest @destinations)))]
     [:footer "footer"]]))
