import { DefineComponent } from 'vue';

declare module 'fu-icon' {
    const FuIcon: DefineComponent<{}, {}, any>;

    export default FuIcon;
}
