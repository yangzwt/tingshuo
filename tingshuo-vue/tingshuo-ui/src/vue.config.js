module.exports = defineConfig({
  lintOnSave: false, 
  devServer: {
    post: 8080,
    host: "localhost",
    open: true
  },

  rules: {
    "vue/multi-word-component-names": "off"
  }
});
