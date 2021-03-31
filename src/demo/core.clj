(ns demo.core
  (:require [clojure.data.json :as json]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.content-type :refer [wrap-content-type]]
            [ring.adapter.jetty :as jetty])
  (:import org.eclipse.jetty.server.Server))

(defn html-handler [request]
  {:status 200
   :body "Hello world!"})

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
   (wrap-content-type)))

(def ^Server server
  (jetty/run-jetty app {:port 3000 :join? false}))

(comment
  (-> server .stop))
