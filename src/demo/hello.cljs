(ns demo.hello
  (:require ["dayjs" :as dayjs]
            [reagent.core :as reagent]
            [reagent.dom :as reagent-dom]))

(println "Hello from println")
(js/console.log "Hello from console.log")
;; (js/alert "Hello from cljs repl w00t??? 2 repls working togeteher asd asds asd asd a")

(def hello (let [h4 (-> js/document
                        (.createElement "h4"))]
             (set! (.-innerHTML h4) "Helllooooooo")
             h4))

(println hello)

(.appendChild js/document.body hello)

(defn main []
  (let [now (dayjs)
        ddmm (.format now "DD/MM/YYYY")]
    [:div
     [:p ddmm]
     [:h3 "Rendering from reagent"]])
  )

(reagent-dom/render
 [main]
 js/document.body)
