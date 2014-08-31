(defproject doorguess "0.1.0-SNAPSHOT"
  :description "Door guessing game"
  :url "http://github.com/tomasv/doorguess"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [com.cemerick/piggieback "0.1.3"]
                 [prismatic/dommy "0.1.3"]
                 [org.clojure/clojurescript "0.0-2322"]]

  :plugins [[lein-cljsbuild "1.0.3"]]
  :hooks [leiningen.cljsbuild]

  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
  :source-paths ["src"]

  :cljsbuild
  {:builds [{:source-paths ["src"]
             :compiler
             {:output-to "web/js/main.js"
              :output-dir "web/js/out"
              :optimizations :whitespace
              :source-map "web/js/main.js.map"
              :pretty-print true}}]})
