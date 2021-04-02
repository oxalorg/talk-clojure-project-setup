(ns demo.hello)

(println "Hello from println")
(js/console.log "Hello from console.log")
(js/alert "Hello from alert")


(def hello (let [h4 (-> js/document
                        (.createElement "h4"))]
             (set! (.-innerHTML h4) "Helllooooooo")
             h4))

(println hello)

(.appendChild js/document.body hello)
