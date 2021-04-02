(ns demo.hello
  (:require [reagent.core :as reagent]
            [reagent.dom :as reagent-dom]))

(println "Hello from println")
(js/console.log "Hello from console.log")
(js/alert "Hello from cljs repl w00t??? 2 repls working togeteher asd asds asd asd a")


(def hello (let [h4 (-> js/document
                        (.createElement "h4"))]
             (set! (.-innerHTML h4) "Helllooooooo")
             h4))

(println hello)

(.appendChild js/document.body hello)

(reagent-dom/render
 [:h3 "Rendering from reagent"]
 js/document.body)
