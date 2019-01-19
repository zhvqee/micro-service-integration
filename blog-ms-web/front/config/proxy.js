const path = require('path');
const proxy = require('http-proxy-middleware');
const PATH_CONFIG_DEV = path.join(__dirname, './dev.env.js');

module.exports = () => {
  return (req, res) => {
    // 使得服务启动中修改开发配置也生效
    delete require.cache[PATH_CONFIG_DEV];
    const freshDevConfig = require(PATH_CONFIG_DEV);

    const proxyTargetKey = freshDevConfig.proxyTargetKey;
    const proxyMap = require('./proxy.map');
    const target = proxyMap[proxyTargetKey];
    if (!target) {
      throw Error(`The target key '${proxyTargetKey}' does not exist in 'config/proxy.map.js'!`)
    }
    const {
      method,
      path: requestPath,
    } = req;
    console.log(`'${method} ${requestPath}' 代理目标: ${proxyTargetKey} => ${target}`);
    proxy({
      target,
      changeOrigin: true,
    })(req, res);
  }
}
