(ns user
  (:require [demo.core :refer [new-jetty]]
            [clojure.tools.namespace.repl :refer [refresh]]
            [ring.adapter.jetty :as jetty]
            [shadow.cljs.devtools.server :as server]
            [shadow.cljs.devtools.api :as shadow])
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

(defn shadow-portal []
  (server/start!)
  (shadow/watch :demo)
  (shadow/nrepl-select :demo))

(comment
  (start-server)
  (reset-server))
