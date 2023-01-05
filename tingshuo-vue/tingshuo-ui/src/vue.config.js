module.exports = {
  lintOnSave: false, 
  devServer: {
    post: 8080,
    host: "localhost",
    open: true
  },

  rules: {
    "vue/multi-word-component-names": "off"
  }
};


// "devDependencies": {
//   "@babel/core": "^7.12.16",
//   "@babel/eslint-parser": "^7.12.16",
//   "@vue/cli-plugin-babel": "~5.0.0",
//   "@vue/cli-plugin-eslint": "~5.0.0",
//   "@vue/cli-service": "~5.0.0",
//   "eslint": "^7.32.0",
//   "eslint-plugin-vue": "^8.0.3",
//   "vue-template-compiler": "^2.6.14"
// },