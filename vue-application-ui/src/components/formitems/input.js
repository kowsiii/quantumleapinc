export default {
  props: {
    id: { type: String, default: null },
    name: { type: String, required: true },
    form: { type: Object, required: false },
    value: { required: false },
    required: { type: Boolean, default: false },
    disabled: { type: Boolean, default: false },
    label: { type: String, default: ''},
    placeholder: { type: String, default: '' },
    description: { type: String, default: '' },
    descriptionf: { type: String, default: '' },
    readonly: { type: Boolean, default: true },
    required: { type: Boolean, default: false },
    options: {type: Array, default: []},
    inline: { type: Boolean, default: true },
  },

  data() {
    return {
      content: this.value,
    };
  },

  computed: {},
};
