(ns demo.core
  (:require [ring.adapter.jetty :as jetty])
  (:import org.eclipse.jetty.server.Server))

(defn handler [request]
  {:status 200
   :body "Hello world!"})

(def ^Server server
  (jetty/run-jetty handler {:port 3000 :join? false}))

(-> server .stop)
