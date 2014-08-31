(ns doorguess.core
  (:require
    [dommy.core :as dommy])
  (:use-macros
    [dommy.macros :only [sel sel1]]))

(defn- str->int [s]
  (js/parseInt s))

(defn- prize-door? [n]
  (let [prize-number (inc (rand-int 3))]
    (= n prize-number)))

(defn- show-result [s]
  (dommy/set-text! (sel1 "#result") s))

(defn- win []
  (show-result "correct"))

(defn- lose []
  (show-result "wrong choice"))

(defn- open-door [n]
  (if (prize-door? n)
    (win)
    (lose)))

(defn- on-click [event button]
  (open-door (str->int (-> button .-dataset .-number))))

(defn- find-buttons []
  (sel ".js-button"))

(defn- on-load []
  (doseq [button (find-buttons)]
    (.addEventListener button "click" #(on-click %1 button))))

(aset js/window "onload" on-load)
