(ns user
  (:require [demo.core :refer [new-jetty]]
            [clojure.tools.namespace.repl :refer [refresh]]
            [ring.adapter.jetty :as jetty])
  (:import org.eclipse.jetty.server.Server))

(def server (atom nil))

(defn start-server []
  (when (nil? @server)
    (reset! server (new-jetty))))

(defn stop-server []
  (.stop @server)
  (reset! server nil))

(defn reset-server []
  (stop-server)
  (refresh :after 'user/start-server))

(comment
  (start-server)
  (reset-server))
