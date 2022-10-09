import { mount } from "@vue/test-utils";
import HelloWorld from "./src/components/HelloWorld.vue";
import { describe, it, expect, vi } from "vitest";


describe("HelloWorld.vue", () => {

    it("should renders is page content is correct", () => {
        const wrapper = mount(HelloWorld, {
            props: {
                msg: "hello"
            }
        });

        expect(wrapper.text()).contains("hello");
    });

    it("should renders is page content is correct", () => {
        const wrapper = mount(HelloWorld, {
            props: {
                msg: "hello"
            }
        });

        expect(wrapper.vm.msg).toBe("hello");
    });

});