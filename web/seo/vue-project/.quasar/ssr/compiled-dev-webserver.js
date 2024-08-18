var __create = Object.create;
var __defProp = Object.defineProperty;
var __getOwnPropDesc = Object.getOwnPropertyDescriptor;
var __getOwnPropNames = Object.getOwnPropertyNames;
var __getProtoOf = Object.getPrototypeOf;
var __hasOwnProp = Object.prototype.hasOwnProperty;
var __export = (target, all) => {
  for (var name in all)
    __defProp(target, name, { get: all[name], enumerable: true });
};
var __copyProps = (to, from, except, desc) => {
  if (from && typeof from === "object" || typeof from === "function") {
    for (let key of __getOwnPropNames(from))
      if (!__hasOwnProp.call(to, key) && key !== except)
        __defProp(to, key, { get: () => from[key], enumerable: !(desc = __getOwnPropDesc(from, key)) || desc.enumerable });
  }
  return to;
};
var __toESM = (mod, isNodeMode, target) => (target = mod != null ? __create(__getProtoOf(mod)) : {}, __copyProps(
  isNodeMode || !mod || !mod.__esModule ? __defProp(target, "default", { value: mod, enumerable: true }) : target,
  mod
));
var __toCommonJS = (mod) => __copyProps(__defProp({}, "__esModule", { value: true }), mod);

// .quasar/ssr-dev-webserver.js
var ssr_dev_webserver_exports = {};
__export(ssr_dev_webserver_exports, {
  close: () => close,
  create: () => create,
  injectMiddlewares: () => injectMiddlewares,
  listen: () => listen,
  serveStaticContent: () => serveStaticContent
});
module.exports = __toCommonJS(ssr_dev_webserver_exports);

// src-ssr/server.ts
var import_express = __toESM(require("express"));
var import_compression = require("compression");
var import_wrappers = require("quasar/wrappers");
var create = (0, import_wrappers.ssrCreate)(() => {
  const app = (0, import_express.default)();
  app.disable("x-powered-by");
  if (false) {
    app.use(compression());
  }
  return app;
});
var listen = (0, import_wrappers.ssrListen)(async ({ app, port, isReady }) => {
  await isReady();
  return app.listen(port, () => {
    if (false) {
      console.log("Server listening at port " + port);
    }
  });
});
var close = (0, import_wrappers.ssrClose)(({ listenResult }) => {
  return listenResult.close();
});
var maxAge = true ? 0 : 1e3 * 60 * 60 * 24 * 30;
var serveStaticContent = (0, import_wrappers.ssrServeStaticContent)((path, opts) => {
  return import_express.default.static(path, {
    maxAge,
    ...opts
  });
});
var jsRE = /\.js$/;
var cssRE = /\.css$/;
var woffRE = /\.woff$/;
var woff2RE = /\.woff2$/;
var gifRE = /\.gif$/;
var jpgRE = /\.jpe?g$/;
var pngRE = /\.png$/;
var renderPreloadTag = (0, import_wrappers.ssrRenderPreloadTag)((file) => {
  if (jsRE.test(file) === true) {
    return `<link rel="modulepreload" href="${file}" crossorigin>`;
  }
  if (cssRE.test(file) === true) {
    return `<link rel="stylesheet" href="${file}">`;
  }
  if (woffRE.test(file) === true) {
    return `<link rel="preload" href="${file}" as="font" type="font/woff" crossorigin>`;
  }
  if (woff2RE.test(file) === true) {
    return `<link rel="preload" href="${file}" as="font" type="font/woff2" crossorigin>`;
  }
  if (gifRE.test(file) === true) {
    return `<link rel="preload" href="${file}" as="image" type="image/gif">`;
  }
  if (jpgRE.test(file) === true) {
    return `<link rel="preload" href="${file}" as="image" type="image/jpeg">`;
  }
  if (pngRE.test(file) === true) {
    return `<link rel="preload" href="${file}" as="image" type="image/png">`;
  }
  return "";
});

// .quasar/ssr-middlewares.js
function injectMiddlewares(opts) {
  return Promise.all([]).then(async (rawMiddlewares) => {
    const middlewares = rawMiddlewares.map((entry) => entry.default);
    for (let i = 0; i < middlewares.length; i++) {
      try {
        await middlewares[i](opts);
      } catch (err) {
        console.error("[Quasar SSR] middleware error:", err);
        return;
      }
    }
  });
}
// Annotate the CommonJS export names for ESM import in node:
0 && (module.exports = {
  close,
  create,
  injectMiddlewares,
  listen,
  serveStaticContent
});
//# sourceMappingURL=data:application/json;base64,ewogICJ2ZXJzaW9uIjogMywKICAic291cmNlcyI6IFsiLi4vc3NyLWRldi13ZWJzZXJ2ZXIuanMiLCAiLi4vLi4vc3JjLXNzci9zZXJ2ZXIudHMiLCAiLi4vc3NyLW1pZGRsZXdhcmVzLmpzIl0sCiAgInNvdXJjZXNDb250ZW50IjogWyIvKiBlc2xpbnQtZGlzYWJsZSAqL1xuLyoqXG4gKiBUSElTIEZJTEUgSVMgR0VORVJBVEVEIEFVVE9NQVRJQ0FMTFkuXG4gKiBETyBOT1QgRURJVC5cbiAqKi9cblxuaW1wb3J0IHsgY3JlYXRlLCBsaXN0ZW4sIGNsb3NlLCBzZXJ2ZVN0YXRpY0NvbnRlbnQgfSBmcm9tICcuLi9zcmMtc3NyL3NlcnZlcidcbmltcG9ydCBpbmplY3RNaWRkbGV3YXJlcyBmcm9tICcuL3Nzci1taWRkbGV3YXJlcydcblxuZXhwb3J0IHtcbiAgY3JlYXRlLFxuICBsaXN0ZW4sXG4gIGNsb3NlLFxuICBzZXJ2ZVN0YXRpY0NvbnRlbnQsXG4gIGluamVjdE1pZGRsZXdhcmVzXG59XG4iLCAiLyoqXG4gKiBNb3JlIGluZm8gYWJvdXQgdGhpcyBmaWxlOlxuICogaHR0cHM6Ly92Mi5xdWFzYXIuZGV2L3F1YXNhci1jbGktdml0ZS9kZXZlbG9waW5nLXNzci9zc3Itd2Vic2VydmVyXG4gKlxuICogUnVucyBpbiBOb2RlIGNvbnRleHQuXG4gKi9cblxuLyoqXG4gKiBNYWtlIHN1cmUgdG8geWFybiBhZGQgLyBucG0gaW5zdGFsbCAoaW4geW91ciBwcm9qZWN0IHJvb3QpXG4gKiBhbnl0aGluZyB5b3UgaW1wb3J0IGhlcmUgKGV4Y2VwdCBmb3IgZXhwcmVzcyBhbmQgY29tcHJlc3Npb24pLlxuICovXG5pbXBvcnQgZXhwcmVzcyBmcm9tICdleHByZXNzJztcbmltcG9ydCBjb21wcmVzc2lvbiBmcm9tICdjb21wcmVzc2lvbic7XG5pbXBvcnQge1xuICBzc3JDbG9zZSxcbiAgc3NyQ3JlYXRlLFxuICBzc3JMaXN0ZW4sXG4gIHNzclJlbmRlclByZWxvYWRUYWcsXG4gIHNzclNlcnZlU3RhdGljQ29udGVudCxcbn0gZnJvbSAncXVhc2FyL3dyYXBwZXJzJztcblxuLyoqXG4gKiBDcmVhdGUgeW91ciB3ZWJzZXJ2ZXIgYW5kIHJldHVybiBpdHMgaW5zdGFuY2UuXG4gKiBJZiBuZWVkZWQsIHByZXBhcmUgeW91ciB3ZWJzZXJ2ZXIgdG8gcmVjZWl2ZVxuICogY29ubmVjdC1saWtlIG1pZGRsZXdhcmVzLlxuICpcbiAqIFNob3VsZCBOT1QgYmUgYXN5bmMhXG4gKi9cbmV4cG9ydCBjb25zdCBjcmVhdGUgPSBzc3JDcmVhdGUoKC8qIHsgLi4uIH0gKi8pID0+IHtcbiAgY29uc3QgYXBwID0gZXhwcmVzcygpO1xuXG4gIC8vIGF0dGFja2VycyBjYW4gdXNlIHRoaXMgaGVhZGVyIHRvIGRldGVjdCBhcHBzIHJ1bm5pbmcgRXhwcmVzc1xuICAvLyBhbmQgdGhlbiBsYXVuY2ggc3BlY2lmaWNhbGx5LXRhcmdldGVkIGF0dGFja3NcbiAgYXBwLmRpc2FibGUoJ3gtcG93ZXJlZC1ieScpO1xuXG4gIC8vIHBsYWNlIGhlcmUgYW55IG1pZGRsZXdhcmVzIHRoYXRcbiAgLy8gYWJzb2x1dGVseSBuZWVkIHRvIHJ1biBiZWZvcmUgYW55dGhpbmcgZWxzZVxuICBpZiAocHJvY2Vzcy5lbnYuUFJPRCkge1xuICAgIGFwcC51c2UoY29tcHJlc3Npb24oKSk7XG4gIH1cblxuICByZXR1cm4gYXBwO1xufSk7XG5cbi8qKlxuICogWW91IG5lZWQgdG8gbWFrZSB0aGUgc2VydmVyIGxpc3RlbiB0byB0aGUgaW5kaWNhdGVkIHBvcnRcbiAqIGFuZCByZXR1cm4gdGhlIGxpc3RlbmluZyBpbnN0YW5jZSBvciB3aGF0ZXZlciB5b3UgbmVlZCB0b1xuICogY2xvc2UgdGhlIHNlcnZlciB3aXRoLlxuICpcbiAqIFRoZSBcImxpc3RlblJlc3VsdFwiIHBhcmFtIGZvciB0aGUgXCJjbG9zZSgpXCIgZGVmaW5pdGlvbiBiZWxvd1xuICogaXMgd2hhdCB5b3UgcmV0dXJuIGhlcmUuXG4gKlxuICogRm9yIHByb2R1Y3Rpb24sIHlvdSBjYW4gaW5zdGVhZCBleHBvcnQgeW91clxuICogaGFuZGxlciBmb3Igc2VydmVybGVzcyB1c2Ugb3Igd2hhdGV2ZXIgZWxzZSBmaXRzIHlvdXIgbmVlZHMuXG4gKi9cbmV4cG9ydCBjb25zdCBsaXN0ZW4gPSBzc3JMaXN0ZW4oYXN5bmMgKHsgYXBwLCBwb3J0LCBpc1JlYWR5IH0pID0+IHtcbiAgYXdhaXQgaXNSZWFkeSgpO1xuICByZXR1cm4gYXBwLmxpc3Rlbihwb3J0LCAoKSA9PiB7XG4gICAgaWYgKHByb2Nlc3MuZW52LlBST0QpIHtcbiAgICAgIGNvbnNvbGUubG9nKCdTZXJ2ZXIgbGlzdGVuaW5nIGF0IHBvcnQgJyArIHBvcnQpO1xuICAgIH1cbiAgfSk7XG59KTtcblxuLyoqXG4gKiBTaG91bGQgY2xvc2UgdGhlIHNlcnZlciBhbmQgZnJlZSB1cCBhbnkgcmVzb3VyY2VzLlxuICogV2lsbCBiZSB1c2VkIG9uIGRldmVsb3BtZW50IG9ubHkgd2hlbiB0aGUgc2VydmVyIG5lZWRzXG4gKiB0byBiZSByZWJvb3RlZC5cbiAqXG4gKiBTaG91bGQgeW91IG5lZWQgdGhlIHJlc3VsdCBvZiB0aGUgXCJsaXN0ZW4oKVwiIGNhbGwgYWJvdmUsXG4gKiB5b3UgY2FuIHVzZSB0aGUgXCJsaXN0ZW5SZXN1bHRcIiBwYXJhbS5cbiAqXG4gKiBDYW4gYmUgYXN5bmMuXG4gKi9cbmV4cG9ydCBjb25zdCBjbG9zZSA9IHNzckNsb3NlKCh7IGxpc3RlblJlc3VsdCB9KSA9PiB7XG4gIHJldHVybiBsaXN0ZW5SZXN1bHQuY2xvc2UoKTtcbn0pO1xuXG5jb25zdCBtYXhBZ2UgPSBwcm9jZXNzLmVudi5ERVYgPyAwIDogMTAwMCAqIDYwICogNjAgKiAyNCAqIDMwO1xuXG4vKipcbiAqIFNob3VsZCByZXR1cm4gbWlkZGxld2FyZSB0aGF0IHNlcnZlcyB0aGUgaW5kaWNhdGVkIHBhdGhcbiAqIHdpdGggc3RhdGljIGNvbnRlbnQuXG4gKi9cbmV4cG9ydCBjb25zdCBzZXJ2ZVN0YXRpY0NvbnRlbnQgPSBzc3JTZXJ2ZVN0YXRpY0NvbnRlbnQoKHBhdGgsIG9wdHMpID0+IHtcbiAgcmV0dXJuIGV4cHJlc3Muc3RhdGljKHBhdGgsIHtcbiAgICBtYXhBZ2UsXG4gICAgLi4ub3B0cyxcbiAgfSk7XG59KTtcblxuY29uc3QganNSRSA9IC9cXC5qcyQvO1xuY29uc3QgY3NzUkUgPSAvXFwuY3NzJC87XG5jb25zdCB3b2ZmUkUgPSAvXFwud29mZiQvO1xuY29uc3Qgd29mZjJSRSA9IC9cXC53b2ZmMiQvO1xuY29uc3QgZ2lmUkUgPSAvXFwuZ2lmJC87XG5jb25zdCBqcGdSRSA9IC9cXC5qcGU/ZyQvO1xuY29uc3QgcG5nUkUgPSAvXFwucG5nJC87XG5cbi8qKlxuICogU2hvdWxkIHJldHVybiBhIFN0cmluZyB3aXRoIEhUTUwgb3V0cHV0XG4gKiAoaWYgYW55KSBmb3IgcHJlbG9hZGluZyBpbmRpY2F0ZWQgZmlsZVxuICovXG5leHBvcnQgY29uc3QgcmVuZGVyUHJlbG9hZFRhZyA9IHNzclJlbmRlclByZWxvYWRUYWcoKGZpbGUpID0+IHtcbiAgaWYgKGpzUkUudGVzdChmaWxlKSA9PT0gdHJ1ZSkge1xuICAgIHJldHVybiBgPGxpbmsgcmVsPVwibW9kdWxlcHJlbG9hZFwiIGhyZWY9XCIke2ZpbGV9XCIgY3Jvc3NvcmlnaW4+YDtcbiAgfVxuXG4gIGlmIChjc3NSRS50ZXN0KGZpbGUpID09PSB0cnVlKSB7XG4gICAgcmV0dXJuIGA8bGluayByZWw9XCJzdHlsZXNoZWV0XCIgaHJlZj1cIiR7ZmlsZX1cIj5gO1xuICB9XG5cbiAgaWYgKHdvZmZSRS50ZXN0KGZpbGUpID09PSB0cnVlKSB7XG4gICAgcmV0dXJuIGA8bGluayByZWw9XCJwcmVsb2FkXCIgaHJlZj1cIiR7ZmlsZX1cIiBhcz1cImZvbnRcIiB0eXBlPVwiZm9udC93b2ZmXCIgY3Jvc3NvcmlnaW4+YDtcbiAgfVxuXG4gIGlmICh3b2ZmMlJFLnRlc3QoZmlsZSkgPT09IHRydWUpIHtcbiAgICByZXR1cm4gYDxsaW5rIHJlbD1cInByZWxvYWRcIiBocmVmPVwiJHtmaWxlfVwiIGFzPVwiZm9udFwiIHR5cGU9XCJmb250L3dvZmYyXCIgY3Jvc3NvcmlnaW4+YDtcbiAgfVxuXG4gIGlmIChnaWZSRS50ZXN0KGZpbGUpID09PSB0cnVlKSB7XG4gICAgcmV0dXJuIGA8bGluayByZWw9XCJwcmVsb2FkXCIgaHJlZj1cIiR7ZmlsZX1cIiBhcz1cImltYWdlXCIgdHlwZT1cImltYWdlL2dpZlwiPmA7XG4gIH1cblxuICBpZiAoanBnUkUudGVzdChmaWxlKSA9PT0gdHJ1ZSkge1xuICAgIHJldHVybiBgPGxpbmsgcmVsPVwicHJlbG9hZFwiIGhyZWY9XCIke2ZpbGV9XCIgYXM9XCJpbWFnZVwiIHR5cGU9XCJpbWFnZS9qcGVnXCI+YDtcbiAgfVxuXG4gIGlmIChwbmdSRS50ZXN0KGZpbGUpID09PSB0cnVlKSB7XG4gICAgcmV0dXJuIGA8bGluayByZWw9XCJwcmVsb2FkXCIgaHJlZj1cIiR7ZmlsZX1cIiBhcz1cImltYWdlXCIgdHlwZT1cImltYWdlL3BuZ1wiPmA7XG4gIH1cblxuICByZXR1cm4gJyc7XG59KTtcbiIsICIvKiBlc2xpbnQtZGlzYWJsZSAqL1xuLyoqXG4gKiBUSElTIEZJTEUgSVMgR0VORVJBVEVEIEFVVE9NQVRJQ0FMTFkuXG4gKiBETyBOT1QgRURJVC5cbiAqKi9cblxuZXhwb3J0IGRlZmF1bHQgZnVuY3Rpb24gaW5qZWN0TWlkZGxld2FyZXMgKG9wdHMpIHtcbiAgcmV0dXJuIFByb21pc2UuYWxsKFtcbiAgICBcbiAgXSkudGhlbihhc3luYyByYXdNaWRkbGV3YXJlcyA9PiB7XG4gICAgY29uc3QgbWlkZGxld2FyZXMgPSByYXdNaWRkbGV3YXJlc1xuICAgICAgLm1hcChlbnRyeSA9PiBlbnRyeS5kZWZhdWx0KVxuXG4gICAgZm9yIChsZXQgaSA9IDA7IGkgPCBtaWRkbGV3YXJlcy5sZW5ndGg7IGkrKykge1xuICAgICAgdHJ5IHtcbiAgICAgICAgYXdhaXQgbWlkZGxld2FyZXNbaV0ob3B0cylcbiAgICAgIH1cbiAgICAgIGNhdGNoIChlcnIpIHtcbiAgICAgICAgY29uc29sZS5lcnJvcignW1F1YXNhciBTU1JdIG1pZGRsZXdhcmUgZXJyb3I6JywgZXJyKVxuICAgICAgICByZXR1cm5cbiAgICAgIH1cbiAgICB9XG4gIH0pXG59XG4iXSwKICAibWFwcGluZ3MiOiAiOzs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7O0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBOzs7QUNXQSxxQkFBb0I7QUFDcEIseUJBQXdCO0FBQ3hCLHNCQU1PO0FBU0EsSUFBTSxhQUFTLDJCQUFVLE1BQW1CO0FBQ2pELFFBQU0sVUFBTSxlQUFBQSxTQUFRO0FBSXBCLE1BQUksUUFBUSxjQUFjO0FBSTFCLE1BQUksT0FBa0I7QUFDcEIsUUFBSSxJQUFJLFlBQVksQ0FBQztBQUFBLEVBQ3ZCO0FBRUEsU0FBTztBQUNULENBQUM7QUFhTSxJQUFNLGFBQVMsMkJBQVUsT0FBTyxFQUFFLEtBQUssTUFBTSxRQUFRLE1BQU07QUFDaEUsUUFBTSxRQUFRO0FBQ2QsU0FBTyxJQUFJLE9BQU8sTUFBTSxNQUFNO0FBQzVCLFFBQUksT0FBa0I7QUFDcEIsY0FBUSxJQUFJLDhCQUE4QixJQUFJO0FBQUEsSUFDaEQ7QUFBQSxFQUNGLENBQUM7QUFDSCxDQUFDO0FBWU0sSUFBTSxZQUFRLDBCQUFTLENBQUMsRUFBRSxhQUFhLE1BQU07QUFDbEQsU0FBTyxhQUFhLE1BQU07QUFDNUIsQ0FBQztBQUVELElBQU0sU0FBUyxPQUFrQixJQUFJLE1BQU8sS0FBSyxLQUFLLEtBQUs7QUFNcEQsSUFBTSx5QkFBcUIsdUNBQXNCLENBQUMsTUFBTSxTQUFTO0FBQ3RFLFNBQU8sZUFBQUEsUUFBUSxPQUFPLE1BQU07QUFBQSxJQUMxQjtBQUFBLElBQ0EsR0FBRztBQUFBLEVBQ0wsQ0FBQztBQUNILENBQUM7QUFFRCxJQUFNLE9BQU87QUFDYixJQUFNLFFBQVE7QUFDZCxJQUFNLFNBQVM7QUFDZixJQUFNLFVBQVU7QUFDaEIsSUFBTSxRQUFRO0FBQ2QsSUFBTSxRQUFRO0FBQ2QsSUFBTSxRQUFRO0FBTVAsSUFBTSx1QkFBbUIscUNBQW9CLENBQUMsU0FBUztBQUM1RCxNQUFJLEtBQUssS0FBSyxJQUFJLE1BQU0sTUFBTTtBQUM1QixXQUFPLG1DQUFtQztBQUFBLEVBQzVDO0FBRUEsTUFBSSxNQUFNLEtBQUssSUFBSSxNQUFNLE1BQU07QUFDN0IsV0FBTyxnQ0FBZ0M7QUFBQSxFQUN6QztBQUVBLE1BQUksT0FBTyxLQUFLLElBQUksTUFBTSxNQUFNO0FBQzlCLFdBQU8sNkJBQTZCO0FBQUEsRUFDdEM7QUFFQSxNQUFJLFFBQVEsS0FBSyxJQUFJLE1BQU0sTUFBTTtBQUMvQixXQUFPLDZCQUE2QjtBQUFBLEVBQ3RDO0FBRUEsTUFBSSxNQUFNLEtBQUssSUFBSSxNQUFNLE1BQU07QUFDN0IsV0FBTyw2QkFBNkI7QUFBQSxFQUN0QztBQUVBLE1BQUksTUFBTSxLQUFLLElBQUksTUFBTSxNQUFNO0FBQzdCLFdBQU8sNkJBQTZCO0FBQUEsRUFDdEM7QUFFQSxNQUFJLE1BQU0sS0FBSyxJQUFJLE1BQU0sTUFBTTtBQUM3QixXQUFPLDZCQUE2QjtBQUFBLEVBQ3RDO0FBRUEsU0FBTztBQUNULENBQUM7OztBQy9IYyxTQUFSLGtCQUFvQyxNQUFNO0FBQy9DLFNBQU8sUUFBUSxJQUFJLENBRW5CLENBQUMsRUFBRSxLQUFLLE9BQU0sbUJBQWtCO0FBQzlCLFVBQU0sY0FBYyxlQUNqQixJQUFJLFdBQVMsTUFBTSxPQUFPO0FBRTdCLGFBQVMsSUFBSSxHQUFHLElBQUksWUFBWSxRQUFRLEtBQUs7QUFDM0MsVUFBSTtBQUNGLGNBQU0sWUFBWSxHQUFHLElBQUk7QUFBQSxNQUMzQixTQUNPLEtBQVA7QUFDRSxnQkFBUSxNQUFNLGtDQUFrQyxHQUFHO0FBQ25EO0FBQUEsTUFDRjtBQUFBLElBQ0Y7QUFBQSxFQUNGLENBQUM7QUFDSDsiLAogICJuYW1lcyI6IFsiZXhwcmVzcyJdCn0K
