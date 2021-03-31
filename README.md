## clojure script

first run

``` sh
clj --main cljs.main --compile hello-world.core
mv out resources/public/

# advanced
clj --main cljs.main -d resources/public/out -co "{:output-to \"resources/public/out/hello.js\" :asset-path \"out\"}" -w src --compile demo.hello
```
