(ns demo.core
  (:require [clojure.data.json :as json]
            [hiccup.core :as h]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.content-type :refer [wrap-content-type]]
            [ring.adapter.jetty :as jetty])
  (:import org.eclipse.jetty.server.Server))

(defn html-handler [request]
  {:status 200
   :body (h/html
          [:html
           [:head
            [:script {:type "application/javascript" :src "/simple.js"}]]
           [:body
            [:h2 "Hello world!"]]])})

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

(def ^Server server
  (jetty/run-jetty (var app) {:port 3000 :join? false}))

(comment
  (-> server .stop))
