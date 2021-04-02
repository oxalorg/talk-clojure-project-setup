# Clojure + Clojurescript project setup

- Ring + Jetty backend server
- JSON api handler + HTML page handler
- Hiccup and rendering html
- CSS files
- Simple vanilla clojurescript example (no additional tools)
- Autobuilding cljs->js (no additiona tools, except cljs itself)
- Solving server startup with `dev/user.clj`
- REPL jacking in with dev profile
- Easier server lifecycle management
- Adding in shadow-cljs and jacking in with clj&cljs BOTH
- Adding Reagent and fetching our API from frontend
- Adding Integrant
- Small quick notes on repl_sessions and easy deployment

## TODO notes

first run

``` sh
clj --main cljs.main --compile hello-world.core
mv out resources/public/

# advanced
clj --main cljs.main -d resources/public/out -co "{:output-to \"resources/public/out/hello.js\" :asset-path \"out\"}" -w src --compile demo.hello
```
