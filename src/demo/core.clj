(ns demo.core
  (:require [clojure.data.json :as json]
            [hiccup.core :as h]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.content-type :refer [wrap-content-type]])
  )

(defn html-handler [request]
  {:status 200
   :body (h/html
          [:html
           [:body
            [:h2 "Hello world again!"]
            [:script {:type "application/javascript" :src "/out/hello.js"}]]])})

(defn json-handler [request]
  {:status 200
   :headers {"Content-Type" "text/json"}
   :body (json/write-str {:galaxies ["andromeda" "milkyway"]})})

(defn handler [request]
  (case (:uri request)
    "/json" (json-handler request)
    (html-handler request)))

(def app
  (->
   (wrap-resource handler "public")
   #_(wrap-content-type)))

(defn new-jetty []
  (jetty/run-jetty (var app) {:port 3000 :join? false}))
